package Currency_nofsc4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DAO.VaultDAO;


public class Vault {
    List<Coin> coins = new ArrayList<>();
    private VaultDAO dao;
    private String guildId;
    private String userId;

    /**
     * @pre | guildId != null && userId != null
     * @post | will make a db if not exists or get the data from the one that already exists!
     * 		 | will load the user's coins if existed!
     */
    public Vault(String guildId, String userId) {
        this.guildId = guildId;
        this.userId = userId;
        this.dao = new VaultDAO(guildId);
        loadVault();
    }
    
    /**  
     * @return | userId of the Vault's Owner
     */
    public String getUserId() {
    	return userId;
    }
    
    /**
     * 
     * @return | guildId where this Vault is at.
     */
    public String getGuildId() {
    	return guildId;
    }

    /**
     * Help function for loading the coins if they exist
     */
    private void loadVault() {
        coins = dao.loadCoins(userId, guildId);
        for (Coin coin : coins) {
            coin.vault = this;
        }
    }

    /**
     * @mutates_properties | getCoins(),coin.getVault()
     * @important | saves the coins directly !
     */
    public void addCoin(Coin coin) {
        if (!coins.contains(coin)) {
            coins.add(coin);
            coin.vault = this;
            dao.saveCoin(userId, guildId, coin);
        }
    }
    /**
     * @mutates_properties | getCoins(),coin.getVault()
     * @important | saves the coins directly !
     */
    public void removeCoin(String coinId) {
        // First, find the coin in the vault
        Coin toRemove = null;
        for (Coin coin : coins) {
            if (coin.getCoinId().equals(coinId)) {
                toRemove = coin;
                break;
            }
        }

        // If found, remove from vault and database
        if (toRemove != null) {
        	toRemove.vault = null;
            coins.remove(toRemove);
            dao.removeCoin(coinId);
        }
    }
    
    public void removeAllCoinsFrom(String userId) {
    	coins.stream().forEach(coin -> coin.vault = null);
    	coins.clear();
    	dao.deleteAllCoinsForUser(userId);
    }


    /**
     * @post | get All coins regardless of the type
     * @post | result.stream().allMatch(coin -> coin.vault.equals(this))
     */
    public List<Coin> getCoins() {
        return Collections.unmodifiableList(coins);
    }

    public List<Zyra> getZyras() {
        List<Zyra> zyras = new ArrayList<>();
        for (Coin c : coins) {
            if (c instanceof Zyra) zyras.add((Zyra) c);
        }
        return Collections.unmodifiableList(zyras);
    }

    public List<Xarin> getXarins() {
        List<Xarin> xarins = new ArrayList<>();
        for (Coin c : coins) {
            if (c instanceof Xarin) xarins.add((Xarin) c);
        }
        return Collections.unmodifiableList(xarins);
    }
    

    public void saveDirtyCoins() {
        for (Coin coin : coins) {
            if (coin.isDirty()) {
                dao.saveOrUpdateCoin(userId, guildId, coin);
                coin.markClean();
            }
        }
    }

    
    
}

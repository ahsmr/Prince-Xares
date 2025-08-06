package Currency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public abstract class Coin {
	
	/**
	 * @invar | vault == null || coinId != null
	 */
	protected String coinId;  
	/**
	 * @peerObject
	 */
	boolean dirty = false;
	Rarity rarity;
	/**
	 * @invar | level>=1 && level <=10
	 */
	int level;
	Vault vault = null;
	
	/**
	 * @throws IllegalArgumentException| Arrays.stream(Rarity.values()).noneMatch(r -> r.equals(rarity))
	 * @throws IllegalArgumentException| level < 0 || level > 10
	 * @post | getRarity().equals(rarity)
	 * @post | getLevel() == level
	 * 
	 */
	public Coin(Rarity rarity, int level) {
		
		if (Arrays.stream(Rarity.values()).noneMatch(r -> r.equals(rarity))) {
		    throw new IllegalArgumentException("Rarity "+rarity+" is Not defined.");
		}
		if (level < 0 || level > 10) {
			throw new IllegalArgumentException("Level "+level+" exceeds the expectation.");
		}
		this.rarity = rarity;
		this.level = level;
	}
	
	public String getCoinId() {
        return coinId;
    }
	
	/**
	 * @pre | coinId != null
	 * @post | getVault() == null || getVault().getCoins().stream().noneMatch(coin -> coin.getCoinId().equals(getCoinId()))
	 */
	 public void setCoinId(String coinId) {
	        this.coinId = coinId;
	    }
	
	public String getCoinStat() {
		String type;
		if (this instanceof Xarin) {
			type = "Xarin";
		}
		else if (this instanceof Zyra) {
			type = "Zyra";
		}
		else {
			throw new IllegalArgumentException("This coin is neither Xarin nor Zyra!");
		}
		
		return "Type: "+type+"\n"
			  +"Rarity: "+rarity+"\n"
			  +"Level: "+level;
	}
	
	
	public abstract String generalInfo();
	
	/**
	 * @post | Arrays.stream(Rarity.values()).anyMatch(rarity -> rarity.equals(result))
	 */
	public Rarity getRarity() {
		return rarity;
	}
	
	/**
	 * @post | result >=1 && result <=10
	 */
	public int getLevel() {
		return level;
	}
	
	
	/**
	 * 
	 * @return null if this coin doesn't belong to any Vault
	 */
	public Vault getVault() {
		return vault;
	}
	


	public boolean isDirty() {
	    return dirty;
	}
	/**
	 * @mutates_properties | isDirty()
	 * @post | isDirty() == false
	 */
	public void markClean() {
	    this.dirty = false;
	}

	/**
	 * @mutates_properties | getLevel()
	 * @pre | getLevel() <=10
	 * @post | getLevel() <= 10
	 */
	public  void levelUp() {
		if (level <= 10) {
			level++;
			this.dirty = true;
		}
	}
	/**
	 * @mutates_properties | getLevel()
	 * @pre | level <=10 && level >=1
	 * @post | getLevel() == level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @mutates_properties | getRarity(),isDirty()
	 * @pre | getRarity() != Rarity.LEGENDARY
	 * @post | getRarity().ordinal() == old(getRarity()).ordinal() +1
	 */
	public void gradeUp() {
		int ordinal = rarity.ordinal();
		if (ordinal < Rarity.values().length-1) {
			rarity = Rarity.values()[ordinal+1] ;
			this.dirty = true;
			
		}
	}
}

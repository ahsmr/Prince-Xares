package DAO;

import java.util.ArrayList;
import java.util.List;

public class GuildInfo {
    private final String guildId;
    private final String shopChannelId;
    private final String introChannelId;
    private final String pouchShopMessageId;
    private final String roleShopMessageId;
    private final String controleChannelId;
    private final List<String> roleIds;

    public GuildInfo(String guildId, String shopChannelId, String introChannelId,String controleChannelId,String pouchShopMessageId,String roleShopMessageId, List<String> roleIds) {
        this.guildId = guildId;
        this.shopChannelId = shopChannelId;
        this.introChannelId = introChannelId;
        this.pouchShopMessageId = pouchShopMessageId;
        this.roleShopMessageId = roleShopMessageId;
        this.controleChannelId = controleChannelId;
        this.roleIds = new ArrayList<String>(roleIds);
        
    }

    public String getGuildId() { return guildId; }
    public String getShopChannelId() { return shopChannelId; }
    public String getIntroChannelId() { return introChannelId; }
    public String getpouchShopMessageId() {return pouchShopMessageId;}
    public String getroleShopMessageId() {return roleShopMessageId;}
    public String getcontroleChannelId() {return controleChannelId;}
    
    public List<String> getRoleIds() { return new ArrayList<String>(roleIds); }
}

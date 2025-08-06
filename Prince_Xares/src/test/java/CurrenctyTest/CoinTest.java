package CurrenctyTest;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Currency.Rarity;
import Currency.Vault;
import Currency.Xarin;
import Currency.Zyra;

class CoinTest {
	
	Xarin x1 = new Xarin(Rarity.COMMON,3);
	Xarin x2 = new Xarin(Rarity.EPIC,10);
	Xarin x3 = new Xarin(Rarity.LEGENDARY,10);
	
	Zyra z1 = new Zyra(Rarity.RARE,9);
	Zyra z2 = new Zyra(Rarity.RARE,10);
	Zyra z3 = new Zyra(Rarity.LEGENDARY,9);
	

	@Test
	void getCoinIdTest() {
		assertEquals(x1.getCoinId(),null);
		assertEquals(z1.getCoinId(),null);
		
		x1.setCoinId("");
		z1.setCoinId("test");
		assertEquals(x1.getCoinId(),"");
		assertEquals(z1.getCoinId(),"test");
		
	}
	
	@Test
	void getCoinStat() {
		assertEquals(x1.getCoinStat(),"Type: Xarin\n"
				  +"Rarity: COMMON\n"
				  +"Level: 3");
		assertEquals(z1.getCoinStat(),"Type: Zyra\n"
				  +"Rarity: RARE\n"
				  +"Level: 9");
	}
	
	@Test
	void getRarityTest() {
		assertEquals(x1.getRarity(),Rarity.COMMON);
		assertEquals(z1.getRarity(),Rarity.RARE);
		
		z1.gradeUp();
		assertEquals(z1.getRarity(),Rarity.EPIC);
	}
	
	@Test
	void getLevelTest() {
		assertEquals(x1.getLevel(),3);
		assertEquals(z1.getLevel(),9);
		x1.levelUp();
		assertEquals(x1.getLevel(),4);
		
		x1.setLevel(2);
		assertEquals(x1.getLevel(),2);
	}
	@Test
	void getVaultTest() {
		assertEquals(x1.getVault(), null);
	}

}

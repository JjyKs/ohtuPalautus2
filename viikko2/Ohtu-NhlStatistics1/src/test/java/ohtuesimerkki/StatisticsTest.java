
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author jjyks
 */
public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
        
        
    };
    

    @Test
    public void palauttaaPelaajan() {
        
        stats = new Statistics(readerStub);
        assertEquals(stats.search("Kurri").getName(), "Kurri");
    }
    
    @Test
    public void palauttaaNullJosPelaajaaEiLoydy() {
        
        stats = new Statistics(readerStub);
        assertEquals(stats.search("LOL"), null);
    }
    
    @Test
    public void palauttaaJoukkueeseenKuuluvatPelaajat() {
        
        stats = new Statistics(readerStub);
        assertEquals(stats.team("EDM").get(1).getTeam(), "EDM");
        assertEquals(stats.team("EDM").size(), 3);

    }
    
    @Test
    public void topScorersPalauttaaOikeanMaaran() {
       
        stats = new Statistics(readerStub);
        assertEquals(stats.topScorers(2).size(), 3);

    }
}
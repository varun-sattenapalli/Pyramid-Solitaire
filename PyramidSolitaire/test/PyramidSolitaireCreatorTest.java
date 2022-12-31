import static org.junit.Assert.assertEquals;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.MultiPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator.GameType;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import org.junit.Test;

/**
 * Class to test PyramidSolitaireCreator.
 */
public class PyramidSolitaireCreatorTest {

  PyramidSolitaireCreator creator = new PyramidSolitaireCreator();
  BasicPyramidSolitaire basic = new BasicPyramidSolitaire();
  RelaxedPyramidSolitaire relaxed = new RelaxedPyramidSolitaire();
  MultiPyramidSolitaire multipyramid = new MultiPyramidSolitaire();
  GameType type;

  @Test
  public void testPyramidSolitaireCreatorBasic() {
    type = GameType.BASIC;
    assertEquals(basic, creator.create(type));

  }

  @Test
  public void testPyramidSolitaireCreatorRelaxed() {
    type = GameType.RELAXED;
    assertEquals(relaxed, creator.create(type));

  }

  @Test
  public void testPyramidSolitaireCreatorMulti() {
    type = GameType.MULTIPYRAMID;
    assertEquals(multipyramid, creator.create(type));

  }
}
package Score;

import java.util.ArrayList;
import Criteres.Critere;

public interface ScoreFinal extends ScoreChoixMult, ScoreChoixSimple, ScoreChoixSimplePond, ScoreIntervalle{
	public int getScore(ArrayList<Critere> criteres, boolean[] flags) ;
}

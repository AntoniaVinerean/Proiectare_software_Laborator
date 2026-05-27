package Lab11.student;
import java.util.List;
import Lab11.student.ExportStrategy;

public class Decorator implements ExportStrategy {
    private final ExportStrategy ExportStrategydecorat;

    public Decorator(ExportStrategy ExportStrategydecorat){
        this.ExportStrategydecorat = ExportStrategydecorat;
    }

    @Override
    public void exporta(List<Studenti> lista) {
        long timpStart=System.currentTimeMillis();
        ExportStrategydecorat.exporta(lista);
        long timpEnd=System.currentTimeMillis();
        long timpTotal=timpEnd-timpStart;
        System.out.println("Timp de executie pentru export:"+timpTotal);
    }

}

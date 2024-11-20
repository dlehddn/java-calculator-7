package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiters {
    private final List<Delimiter> delimiters;

    public Delimiters() {
        List<Delimiter> delimiters = new ArrayList<>();
        addDefaultDelimiters(delimiters);
        this.delimiters = delimiters;
    }

    public void add(Delimiter delimiter) {
        delimiters.add(delimiter);
    }

    public List<Delimiter> getDelimiters() {
        return delimiters;
    }

    private void addDefaultDelimiters(List<Delimiter> delimiters) {
        delimiters.add(new Delimiter(','));
        delimiters.add(new Delimiter(':'));
    }


}

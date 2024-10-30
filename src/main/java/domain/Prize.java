package domain;

import java.util.Objects;

public class Prize {
    private final int cost;

    public Prize(int cost) {
        this.cost = cost;
    }

    public String costToString() {
        if (cost ==0)
            return "꽝";

        return String.valueOf(cost);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return cost == prize.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cost);
    }
}

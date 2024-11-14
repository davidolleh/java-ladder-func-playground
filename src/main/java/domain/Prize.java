package domain;

import java.util.Objects;

public class Prize {
    private final int cost;

    public Prize(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
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

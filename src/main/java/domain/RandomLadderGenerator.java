package domain;

import java.util.List;

public interface RandomLadderGenerator {
    List<Line> generateLadder(int lineHeight, int ladderWidth);
}

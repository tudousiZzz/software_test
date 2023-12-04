package com.exam.util;

import com.exam.entity.Score;

public class ScoreUtil {

    public static boolean check(Score score) {

        Integer ptScore = score.getPtScore();
        Integer etScore = score.getEtScore();

        return ptScore >= 0 && ptScore <= 40 && etScore >= 0 && etScore <= 60;
    }

    public static Integer sumScore(Score score) {

        if (!check(score)) return -1;

        Integer ptScore = score.getPtScore();
        Integer etScore = score.getEtScore();

        return ptScore + etScore;
    }
}

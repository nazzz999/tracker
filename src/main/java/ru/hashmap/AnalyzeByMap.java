package ru.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        int totalSubject = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubject++;
            }
        }
        return totalSubject == 0 ? 0D : totalScore / totalSubject;
    }

    private static int calculateTotalScore(Pupil pupil) {
        int totalScore = 0;
        for (Subject subject : pupil.subjects()) {
            totalScore += subject.score();
        }
        return totalScore;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = calculateTotalScore(pupil);
            double averageScore = (double) totalScore / pupil.subjects().size();
            labels.add(new Label(pupil.name(), averageScore));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        Map<String, Integer> subjectCounts = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
               subjectScores.put(subject.name(), subjectScores.getOrDefault(subject.name(), 0) + subject.score());
               subjectCounts.put(subject.name(), subjectCounts.getOrDefault(subject.name(), 0) + 1);
            }
        }
        List<Label> labels = new ArrayList<>();
        for (String subjectName : subjectScores.keySet()) {
            double averageScore = (double) subjectScores.get(subjectName) / subjectCounts.get(subjectName);
            labels.add(new Label(subjectName, averageScore));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = calculateTotalScore(pupil);
            labels.add(new Label(pupil.name(), totalScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(subject.name(), subjectScores.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        List<Label> labels = new ArrayList<>();
        for (String subjectName : subjectScores.keySet()) {
            labels.add(new Label(subjectName, subjectScores.get(subjectName)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}


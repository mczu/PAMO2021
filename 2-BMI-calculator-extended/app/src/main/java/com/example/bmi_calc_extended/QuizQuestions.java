package com.example.bmi_calc_extended;

public class QuizQuestions {
    public String coronavirusQuestions[] = {
            "Koronawirus najbardziej szkodliwie oddzialuje na:",
            "Jaka jest oficjalna nazwa koronawirusa?",
            "W jakim mieście koronawirusa wykryto po raz pierwszy?",
            "Okres wylęgania wirusa wynosi",
            "Jak zapobiegać COVID-19?",
            "Jaki dystans zależy zachować od osób, które kaszlą i kichają?",
            "Jak długo Covid-19 przetrwa na powierzchniach?"
    };

    private String answerChoices[][] = {
            {"Układ oddechowy", "Układ pokarmowy", "Układ krwionośny", "Układ nerwowy"},
            {"Sars-CoV-2", "Covid-19", "nCov-2019", "Coronavirus"},
            {"Szanghaj", "Pekin", "Wuhan", "Tajwan"},
            {"1 dzień", "1 tydzień", "1-14 dni", "więcej niż 2 tygodnie"},
            {"Protestować przeciwko Covid-19", "Nie nosić maseczek ochronnych", "Często myć ręce używając mydła i wody", "Pić dużo alkoholu"},
            {"więcej niż 2m", "żaden", "minimum 1m", "50 cm"},
            {"kilka do kilkunastu godzin", "1 dzień", "3 dni", "nie jest pewne"}
    };

    private String CorrectAnswers[] = {
            "Układ oddechowy",
            "Sars-CoV-2",
            "Wuhan",
            "1 tydzień",
            "Często myć ręce używając mydła i wody",
            "minimum 1m",
            "nie jest pewne" };

    public String getQuestion(int a){
        String question = coronavirusQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = answerChoices[a][0];
        return choice;
    }
    public String getChoice2(int a){
        String choice = answerChoices[a][1];
        return choice;
    }
    public String getChoice3(int a){
        String choice = answerChoices[a][2];
        return choice;
    }
    public String getChoice4(int a){
        String choice = answerChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = CorrectAnswers[a];
        return answer;
    }
}

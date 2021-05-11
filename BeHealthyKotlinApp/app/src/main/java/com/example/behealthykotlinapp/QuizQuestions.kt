package com.example.behealthykotlinapp

class QuizQuestions {
    var coronavirusQuestions = arrayOf(
        "Koronawirus najbardziej szkodliwie oddzialuje na:",
        "Jaka jest oficjalna nazwa koronawirusa?",
        "W jakim mieście koronawirusa wykryto po raz pierwszy?",
        "Okres wylęgania wirusa wynosi",
        "Jak zapobiegać COVID-19?",
        "Jaki dystans zależy zachować od osób, które kaszlą i kichają?",
        "Jak długo Covid-19 przetrwa na powierzchniach?"
    )

    private val answerChoices = arrayOf(
        arrayOf("Układ oddechowy", "Układ pokarmowy", "Układ krwionośny", "Układ nerwowy"),
        arrayOf("Sars-CoV-2", "Covid-19", "nCov-2019", "Coronavirus"),
        arrayOf("Szanghaj", "Pekin", "Wuhan", "Tajwan"),
        arrayOf("1 dzień", "1 tydzień", "1-14 dni", "więcej niż 2 tygodnie"),
        arrayOf(
            "Protestować przeciwko Covid-19",
            "Nie nosić maseczek ochronnych",
            "Często myć ręce używając mydła i wody",
            "Pić dużo alkoholu"
        ),
        arrayOf("więcej niż 2m", "żaden", "minimum 1m", "50 cm"),
        arrayOf("kilka do kilkunastu godzin", "1 dzień", "3 dni", "nie jest pewne")
    )

    private val CorrectAnswers = arrayOf(
        "Układ oddechowy",
        "Sars-CoV-2",
        "Wuhan",
        "1 tydzień",
        "Często myć ręce używając mydła i wody",
        "minimum 1m",
        "nie jest pewne"
    )

    fun getQuestion(a: Int): String? {
        return coronavirusQuestions[a]
    }

    fun getChoice1(a: Int): String? {
        return answerChoices[a][0]
    }

    fun getChoice2(a: Int): String? {
        return answerChoices[a][1]
    }

    fun getChoice3(a: Int): String? {
        return answerChoices[a][2]
    }

    fun getChoice4(a: Int): String? {
        return answerChoices[a][3]
    }

    fun getCorrectAnswer(a: Int): String? {
        return CorrectAnswers[a]
    }
}
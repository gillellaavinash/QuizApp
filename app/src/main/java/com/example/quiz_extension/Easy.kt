package com.example.quiz_extension

data class Easy(
    val question : String,
    val answer : Int,
    val options : List<String>
)

val easy_list = listOf(
    Easy(
        "Who painted the Mona Lisa?",
        1,
        listOf("Leonardo da Vinci", "Michelangelo", "Raphael", "Donatello")
    ),
    Easy(
        "What is the capital of France?",
        1,
        listOf("Paris", "London", "Berlin", "Rome")
    ),
    Easy(
        "What is the highest mountain peak in the world?",
        1,
        listOf("Mount Everest",
               "K2",
               "Mount Kilimanjaro",
               "Denali")
    ),
    Easy(
        "In Greek mythology, who is the god of thunder?",
        3,
        listOf("Poseidon", "Athena", "Zeus", "Apollo")
    ),
    Easy(
        "What is the national animal of India?",
        2,
        listOf(" Elephant", "Tiger", "Lion", "Panda")
    ),
    Easy(
        "What is the main ingredient in sushi?",
        3,
        listOf("Chicken", "Noodles", "Rice", "Tofu")
    ),
    Easy(
        "What is the capital of Australia?",
        1,
        listOf("Canberra", "Sydney", "Melbourne", "Perth")
    ),
    Easy(
        "What is the name of the fictional spaceship in the Star Wars franchise?",
        4,
        listOf("TARDIES", "Serenity", "Enterprise", " Millennium Falcon")
    ),
    Easy(
        "Which of these instruments belongs to the string family?",
        2,
        listOf("Flute", "Violin ", "Trumpet", "Drums")
    ),
    Easy(
        "What is the symbol used for the power button on most electronics?",
        3,
        listOf("Circle", "Square", "Triangle", "Star")
    )
)


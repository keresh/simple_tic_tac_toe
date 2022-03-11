package tictactoe

const val NUM_ZERO = 0
const val NUM_ONE = 1
const val NUM_TWO = 2
const val NUM_THREE = 3
const val NUM_SIX = 6
const val NUM_NINE = 9

var globalXCount = 0
var globalOCount = 0

fun main() {
    val input: MutableList<Char> = mutableListOf()
    val stage = createStage(input)
    game(stage)
}

fun game(stage: MutableList<MutableList<Char>>): Unit {
    var stamp = 'X'
    printStage(stage)
    while(true) {
        val coordinates: List<Int> = readLine()!!.split(" ").map { it.toInt() }
        println("Enter the coordinates: ${coordinates[0]} ${coordinates[1]}")
        val isValid = analyzeMove(coordinates, stage)
        if (isValid){
            stage[coordinates[0] -1][coordinates[1] -1] = stamp
            when (stamp) {
                'X' -> stamp = 'O'
                'O' -> stamp = 'X'
            }
            when (analyzeStage(stage)) {
                "Game not finished" -> {
                    printStage(stage)
                    continue
                }
                "Draw", "X wins", "O wins" -> {
                    printStage(stage)
                    println(analyzeStage(stage))
                    break
                }
                else -> {
                    println(analyzeStage(stage))
                    break
                }
            }
        } else {
            continue
        }
    }
}

fun createStage (input: MutableList<Char>): MutableList<MutableList<Char>> {
    for (i in 0 until 9) input.add(' ')
    return mutableListOf(
        input.subList(NUM_ZERO, NUM_THREE),
        input.subList(NUM_THREE, NUM_SIX),
        input.subList(NUM_SIX, NUM_NINE)
    )
}

fun printStage(stage: MutableList<MutableList<Char>>): Unit {
    println("---------")
    println("| ${stage[NUM_ZERO].joinToString(" ")} |")
    println("| ${stage[NUM_ONE].joinToString(" ")} |")
    println("| ${stage[NUM_TWO].joinToString(" ")} |")
    println("---------")
}

fun analyzeStage(stage: MutableList<MutableList<Char>>): String {
    var xWins = false
    var oWins = false
    globalXCount = 0
    globalOCount = 0
    val rowCheck = checkBoardRows(stage)
    val columnCheck = checkBoardColumns(stage)
    val crossCheck = checkBoardCross(stage)

    if (rowCheck[0] || columnCheck[0] || crossCheck[0]) xWins = true
    if (rowCheck[1] || columnCheck[1] || crossCheck[1]) oWins = true
    return printResult(xWins, oWins, rowCheck[2])
}

fun checkBoardRows(stage: MutableList<MutableList<Char>>): MutableList<Boolean> {
    var stageHasEmptyCells = false
    var xInARow = false
    var oInARow = false

    for (i in NUM_ZERO..NUM_TWO) {
        var xCount = 0
        var yCount = 0
        for (j in NUM_ZERO..NUM_TWO) {
            if (stage[i][j] == 'X') {
                xCount += 1
                globalXCount += 1
                yCount = 0
            } else if (stage[i][j] == 'O') {
                yCount += 1
                globalOCount += 1
                xCount = 0
            } else {
                stageHasEmptyCells = true
            }
            if(xCount == 3) xInARow = true
            if(yCount == 3) oInARow = true
        }
    }

    return mutableListOf<Boolean>(xInARow, oInARow, stageHasEmptyCells)
}

fun checkBoardColumns(stage: MutableList<MutableList<Char>>): MutableList<Boolean> {
    var xInAColumn = false
    var oInAColumn = false


    for (i in NUM_ZERO..NUM_TWO) {
        var xCount = 0
        var yCount = 0
        for (j in NUM_ZERO..NUM_TWO) {
            if (stage[j][i] == 'X') {
                xCount += 1
                yCount = 0
            } else if (stage[j][i] == 'O') {
                yCount += 1
                xCount = 0
            }
            if(xCount == 3) xInAColumn = true
            if(yCount == 3) oInAColumn = true
        }
    }

    return mutableListOf<Boolean>(xInAColumn, oInAColumn)
}

fun checkBoardCross(stage: MutableList<MutableList<Char>>): MutableList<Boolean> {
    var xInACross = false
    var oInACross = false

    if (
        stage[NUM_ONE][NUM_ONE] == 'X' &&
        ((stage[NUM_ZERO][NUM_ZERO] == 'X' && stage[NUM_TWO][NUM_TWO] == 'X') || (stage[NUM_TWO][NUM_ZERO] == 'X' && stage[NUM_ZERO][NUM_TWO] == 'X'))
    ) {
        xInACross = true
    } else if (stage[NUM_ONE][NUM_ONE] == 'O' &&
        ((stage[NUM_ZERO][NUM_ZERO] == 'O' && stage[NUM_TWO][NUM_TWO] == 'O') || (stage[NUM_TWO][NUM_ZERO] == 'O' && stage[NUM_ZERO][NUM_TWO] == 'O'))
    ) {
        oInACross = true
    }

    return mutableListOf<Boolean>(xInACross, oInACross)
}

fun printResult(xWins: Boolean, oWins: Boolean, stageHasEmptyCells: Boolean): String {
    val result =
        when {
            globalXCount >= globalOCount + 2 || globalOCount >= globalXCount + 2 -> "Impossible"
            !xWins && !oWins && stageHasEmptyCells -> "Game not finished"
            !xWins && !oWins && !stageHasEmptyCells -> "Draw"
            xWins && !oWins -> "X wins"
            !xWins && oWins -> "O wins"
            else -> "Impossible"
        }
    return result
}

fun analyzeMove(coordinates: List<Int>, stage: MutableList<MutableList<Char>>): Boolean {
    val i = coordinates[0] - 1
    val j = coordinates[1] - 1
    var isValid = true

    if (coordinates[0] !in 1..3 || coordinates[1] !in 1..3) {
        println("Coordinates should be from 1 to 3!")
        isValid = false
    } else if (stage[i][j] != '_' && stage[i][j] != ' ') {
        println("This cell is occupied! Choose another one!")
        isValid = false
    }
    return isValid
}
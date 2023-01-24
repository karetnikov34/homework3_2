val amount = 12_100
val day = 0
val month = 0
val card = "VK Pay"

fun main() {
    if (card == "VK Pay" && month + amount > 40_000 || amount > 15_000) {
        println("Лимиты суммы переводов превышены")
    } else if (month + amount > 600_000 || day + amount > 150_000 ) {
        println("Лимиты суммы переводов превышены")
    } else println("Комиссия по операции составляет: ${commission(card, amount, month)} руб.")
}

fun commission(card: String, amount: Int, month: Int) =
    when (card) {
        "VK Pay" -> 0
        "MasterCard", "Maestro" -> if (amount + month < 75000) 0 else (amount - (75000 - month)) * 0.006 + 20
        else -> if (amount * 0.0075 < 35) 35 else amount * 0.0075
    }
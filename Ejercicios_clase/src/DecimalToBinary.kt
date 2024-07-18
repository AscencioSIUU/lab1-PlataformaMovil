

fun DecimalToBinary(n: Int): String{
    var decimalNumber = n
    val binaryString = StringBuilder()

    while (decimalNumber > 0) {
        val remainder = decimalNumber % 2
        binaryString.append(remainder)
        decimalNumber /= 2
    }

    return binaryString.reverse().toString()
}

fun AskUser(){
    var cycle = true
    var wordsArray = mutableListOf<String>()
    var palindrome = 0
    var atLeastTwoVowels = 0
    var beginsWithConsonant = 0


    println("Ingrese sus palabras...")
    while(cycle){
        print("> ")
        val stringInput = readLine()!!
        wordsArray.add(stringInput.lowercase())

        println("ENTER PARA CONTINUAR,  PARA SALIR PRESIONE: 2")
        val choice = readLine()!!
        if (choice == "2") {
            cycle = false
        }
    }

    for (word in wordsArray){
        if(IsPalindrome(word)){
            palindrome++
        }
        if(hasTwoVowels(word)){
            atLeastTwoVowels++
        }
        if(BeginsWithConsonant(word)){
            beginsWithConsonant++
        }
    }
    println("Palabras Palindromas: $palindrome")
    println("Palabras con al menos dos vocales: $atLeastTwoVowels")
    println("Palabras que inician con consonante: $beginsWithConsonant")

}

fun IsPalindrome(text: String): Boolean{
    return text == text.reversed()
}
fun hasTwoVowels(text: String): Boolean{
    val vowels = "aeiouAEIOU"
    var vowelChecked = mutableSetOf<Char>()
    var count = 0
    for (char in text){
        if(char in vowels && !vowelChecked.contains(char)){
            count++
            vowelChecked.add(char)
        }
        if (count >= 2){
            return true
        }
    }
    return false
}
fun BeginsWithConsonant(word: String): Boolean{
    if (word.isEmpty()) return false

    val firstCharacter = word[0]
    return firstCharacter in setOf('a', 'e', 'i', 'o', 'u')
}


fun main(){
    println("helo world")
    println(DecimalToBinary(99343))
    println("11000010000001111")

    AskUser()
}
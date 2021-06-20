package subtask2

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        var aStr =a.toUpperCase()
        val bUpperCase = b.toCharArray()
        bUpperCase.forEachIndexed{index, char -> bUpperCase[index]=char.toUpperCase()}
        for(charOfB in bUpperCase){
            if (aStr.indexOf(charOfB)<0)return "NO" else
                aStr = aStr.substring(aStr.indexOf(charOfB)+1,aStr.length)
        }
        return "YES"
    }

}

fun main(){
    println(Abbreviation().abbreviationFromA("ytrewq","RY"))
}



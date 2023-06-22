package modele

import iut.info1.pickomino.exceptions.IncorrectKeyException

class Player(numberPlayer:Int,localPlayer : Boolean) {
    private val numberPlayer : Int = numberPlayer
    val localPlayer : Boolean = localPlayer
    private var ListPickomino :MutableList<Pickomino> = mutableListOf<Pickomino>()

    public fun countWorms():Int{
        var nb_worms = 0

        for (i in 0..ListPickomino.size-1) {

            nb_worms +=ListPickomino[i].getnbWorm()
        }
        return nb_worms
    }

    public fun firstElement():Pickomino {
        if (ListPickomino.size == 0) {
            throw IncorrectKeyException()
        }
        return ListPickomino[ListPickomino.size-1]
    }

    public fun addElement(Picko: Pickomino) {
        if (ListPickomino.size == 16) {
            return
        }else {
            ListPickomino.add(Picko)
        }
    }

    public fun removeElement():Pickomino {
        var picko = ListPickomino[ListPickomino.size-1]
        try {
            ListPickomino.removeAt(ListPickomino.size-1)
        }
        catch (e:IndexOutOfBoundsException) {
            throw  IncorrectKeyException()
        }
        return picko
    }


    fun topPickominoIs(picko : Pickomino){


        if (picko in ListPickomino){
            if (picko != ListPickomino[ListPickomino.size-1]){
                this.removeElement()
                this.topPickominoIs(picko)
            }
        }
        else{
            if (picko.getValue() == 0 && ListPickomino.size != 0) {
                this.removeElement()
            }
            else if (picko.getValue() != 0){
                this.addElement(picko)
            }
        }


    }

    fun allPickomino() : MutableList<Pickomino>{

        return ListPickomino
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Player

        if (numberPlayer != other.numberPlayer) return false
        if (localPlayer != other.localPlayer) return false
        if (ListPickomino != other.ListPickomino) return false

        return true
    }


}
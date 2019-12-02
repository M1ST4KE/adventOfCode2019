package adventofcode.day02

class IntCodePc constructor(
    private val readOnlyMemory: ArrayList<Int>
) {
    var memory = readOnlyMemory.toMutableList()
        private set
    private var pointer: Int = 0

    fun runProgramme(noun:Int, verb:Int): Int {
        memory[1] = noun
        memory[2] = verb
        while (true) {
            when (memory[pointer]) {
                1 -> addition(
                    memory[pointer + 1],
                    memory[pointer + 2],
                    memory[pointer + 3]
                )
                2 -> multiplication(
                    memory[pointer + 1],
                    memory[pointer + 2],
                    memory[pointer + 3]
                )
                99 -> return memory[0]
                else -> throw Exception("Something went wrong :/")
            }
            nextInstruction()
        }
    }

    fun resetMemory() {
        memory = readOnlyMemory.toMutableList()
        pointer = 0
    }

    private fun addition(val1pos: Int, val2pos: Int, dest: Int) {
        memory[dest] = memory[val1pos] + memory[val2pos]
    }

    private fun multiplication(val1pos: Int, val2pos: Int, dest: Int) {
        memory[dest] = memory[val1pos] * memory[val2pos]
    }

    private fun nextInstruction() {
        pointer += 4;
    }
}

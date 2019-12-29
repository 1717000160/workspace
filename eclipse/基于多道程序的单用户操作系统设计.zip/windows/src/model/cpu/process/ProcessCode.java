package model.cpu.process;

import model.cpu.Compiler;
import model.memory.MemoryOccupy;

public class ProcessCode implements MemoryOccupy {
	private int[] instructions;
	private int index;

	public ProcessCode() {
		this(new int[0]);
	}

	public ProcessCode(int[] instructions) {
		this.instructions = instructions;
	}

	@Override
	public int length() {
		return Math.max(20, instructions.length * 5);
	}


	public int getIns() {
		if (index < instructions.length) {
			return instructions[index];
		}
		return Compiler.getEndCode();
	}

	public int toNext() {
		index++;
		return getIns();
	}


	@Override
	public String toString() {
		String result = "";
		for(int inst:instructions){
			result += Compiler.decode(inst) + '\n';
		}
		return result;
	}
}

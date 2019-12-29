package model.cpu;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import model.cpu.process.PCB;
import model.cpu.process.ProcessCode;
import model.memory.MemoryBlock;


public class PCBManager {

	private ConcurrentHashMap<Integer, PCB> map;

	private LinkedBlockingQueue<Integer> queue;

	public PCBManager() {
		map = new ConcurrentHashMap<>();
		queue = new LinkedBlockingQueue<>(CPU.getMAX_NUMBE_OF_PROCESS());
		for (int i = 0; i < CPU.getMAX_NUMBE_OF_PROCESS(); i++) {
			try {
				queue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private int getNewPID() {
		Integer pid = queue.poll();
		if (pid != null) {
			return pid;
		}
		return -1;
	}

	public PCB allocatePCB(MemoryBlock block, ProcessCode code) {
		int id = getNewPID();
		if (id == -1) {
			return null;
		}
		PCB pcb = new PCB(id, block, code);
		map.put(id, pcb);
		return pcb;
	}

	public PCB getPCB(int pid) {
		return map.get(pid);
	}

	public void recoverPCB(PCB pcb) {
//		/**
//		 * �������й����
//		 */
//		if (pcb.getID() == 0) {
//			return;
//		}
		map.remove(pcb.getID(), pcb);
		try {
			queue.put(pcb.getID());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public boolean available() {
		return !queue.isEmpty();
	}

	public int getPID(MemoryBlock block) {
		for (Entry<Integer, PCB> entry : map.entrySet()) {
			PCB pcb = entry.getValue();
			if (pcb.getMemoryBlock().equals(block)) {
				return pcb.getID();
			}
		}
		return -1;
	}
}

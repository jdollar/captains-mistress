package Joel;

import mainPack.*;
import Mohammed.AbstractGeneralControls;

public class AI extends AbstractGeneralControls {
	private final static int CONSTANTOFSPEED = 10;
	private final int skipCount = 1000 / CONSTANTOFSPEED;

	AI(GameBoardImpl GameBoardPass) {
		super(GameBoardPass);
	}

	public int GetInput(int[][] GameBoard) {
		return 0;
	}

	public void FPSControl() {
		long now = System.currentTimeMillis();
		long nextRun = 0;
		long sleepTimer = 0;
		nextRun += skipCount;

		while (true) {
			sleepTimer = nextRun - System.currentTimeMillis();
			if (sleepTimer >= 0) {
				try {
					// do what you want to do before sleeping
					Thread.currentThread().sleep(sleepTimer);// sleep for 1000
																// ms
					// do what you want to do after sleeptig
				} catch (InterruptedException ie) {
					// If this thread was intrrupted by nother thread
				}
			}
		}
	}

	@Override
	public String[] getLog() {
		// TODO Auto-generated method stub
		return null;
	}
}

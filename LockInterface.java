/**
 * Interface with method for acquiring and releasing the reader and writer lock
 * @author ashishpateria
 *
 */
public interface LockInterface {
	public void acquireReadLock(int readerNum);

	public void acquireWriteLock(int writerNum);

	public void releaseReadLock(int readerNum);

	public void releaseWriteLock(int writerNum);

}

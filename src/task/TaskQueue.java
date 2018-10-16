package task;

import java.util.ArrayList;

public class TaskQueue
{
	boolean mLock = false;
	boolean mAbort = false;
	ArrayList<ITask> mTaskList = new ArrayList<ITask>();
	
	public void addTask(ITask task)
	{
		mTaskList.add(task);
	}
	public void abortAll()
	{
		if(mLock)
			mAbort = true;
		else
			_abortAll();
	}
	public void lockQueue()
	{
		mLock = true;
	}
	public void unLockQueue()
	{
		mLock = false;
	}
	public void process()
	{
		if(mLock) return;
		
		mLock = true;
		while(mTaskList.size() > 0)
		{
			if(mAbort) break;
			
			ITask task = mTaskList.get(0);
			if(task.process())
				mTaskList.remove(task);
			else
				break;
		}
		mLock = false;
		
		_abortAll();
	}
	
	private void _abortAll()
	{
		if(!mAbort)
			return;
		
		mAbort = false;
		for(ITask task : mTaskList)
		{
			task.onAbort();
		}
		mTaskList.clear();
	}
}

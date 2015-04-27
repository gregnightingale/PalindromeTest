abstract public class SearchTemplateMethod implements Strategy {

	@Override
	public void solve() {
		while (true) {
			preProcess();
			if (search())
				break;
			postProcess();
		}
	}

	protected abstract void preProcess();

	protected abstract boolean search();

	protected abstract void postProcess();

}

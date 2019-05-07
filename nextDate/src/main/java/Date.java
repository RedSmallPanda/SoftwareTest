public class Date {
	private Day d;
	private Month m;
	private Year y;

	public Date(int pMonth, int pDay, int pYear) {
		y = new Year(pYear);
		m = new Month(pMonth, y);
		d = new Day(pDay, m);
	}

	public String increment() {
		if (!d.increment()) {
			if (!m.increment()) {
				y.increment();
				m.setMonth(1, y);
			}
			d.setDay(1, m);
		}
		return printDate();
	}

	public String printDate() {
		return (m.getMonth() + "/" + d.getDay() + "/" + y.getYear());
	}

	public Day getDay() {
		return d;
	}

	public Month getMonth() {
		return m;
	}

	public Year getYear() {
		return y;
	}

	public boolean equals(Object o) {
		if (o instanceof Date) {
			if (this.y.equals(((Date) o).y) && this.m.equals(((Date) o).m)
					&& this.d.equals(((Date) o).d))
				return true;
		}
		return false;
	}

	public String toString() {
		return (m.getMonth() + "/" + d.getDay() + "/" + y.getYear());
	}
}

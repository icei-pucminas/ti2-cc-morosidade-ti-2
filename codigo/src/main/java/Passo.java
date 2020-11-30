

import org.json.JSONObject;

public class Passo{
	 private int id;
	 private boolean passo1;
	 private boolean passo2;
	 private boolean passo3;
	 private boolean passo4;
	 private boolean passo5;
	 private boolean passo6;
	 private boolean passo7;
	 private boolean passo8;
	 private boolean passo9;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPasso1() {
		return passo1;
	}

	public void setPasso1(boolean passo1) {
		this.passo1 = passo1;
	}

	public boolean isPasso2() {
		return passo2;
	}

	public void setPasso2(boolean passo2) {
		this.passo2 = passo2;
	}

	public boolean isPasso3() {
		return passo3;
	}

	public void setPasso3(boolean passo3) {
		this.passo3 = passo3;
	}

	public boolean isPasso4() {
		return passo4;
	}

	public void setPasso4(boolean passo4) {
		this.passo4 = passo4;
	}

	public boolean isPasso5() {
		return passo5;
	}

	public void setPasso5(boolean passo5) {
		this.passo5 = passo5;
	}

	public boolean isPasso6() {
		return passo6;
	}

	public void setPasso6(boolean passo6) {
		this.passo6 = passo6;
	}

	public boolean isPasso7() {
		return passo7;
	}

	public void setPasso7(boolean passo7) {
		this.passo7 = passo7;
	}

	public boolean isPasso8() {
		return passo8;
	}

	public void setPasso8(boolean passo8) {
		this.passo8 = passo8;
	}

	public boolean isPasso9() {
		return passo9;
	}

	public void setPasso9(boolean passo9) {
		this.passo9 = passo9;
	}

	@Override
	public String toString() {
		return "passo [id=" + id + ", passo1=" + passo1 + ", passo2=" + passo2 + ", passo3=" + passo3 + ", passo4="
				+ passo4 + ", passo5=" + passo5 + ", passo6=" + passo6 + ", passo7=" + passo7 + ", passo8=" + passo8
				+ ", passo9=" + passo9 + "]";
	}

	public Passo(int id, boolean passo1, boolean passo2, boolean passo3, boolean passo4, boolean passo5, boolean passo6,
			boolean passo7, boolean passo8, boolean passo9) {
		super();
		this.id = id;
		this.passo1 = passo1;
		this.passo2 = passo2;
		this.passo3 = passo3;
		this.passo4 = passo4;
		this.passo5 = passo5;
		this.passo6 = passo6;
		this.passo7 = passo7;
		this.passo8 = passo8;
		this.passo9 = passo9;
	}
	public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id", this.getId());
		obj.put("passo1", this.isPasso1());
		obj.put("passo2", this.isPasso2());
		obj.put("passo3", this.isPasso3());
		obj.put("passo4", this.isPasso4());
		obj.put("passo5", this.isPasso5());
		obj.put("passo6", this.isPasso6());
		obj.put("passo7", this.isPasso7());
		obj.put("passo8", this.isPasso8());
		obj.put("passo9", this.isPasso9());
		return obj;
	}
	 
 }
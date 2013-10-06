// Hashmap
//No duplicate keys

public class HashMap {
	
	private class HashNode {
		private String key;
		private Object o;
		
		public HashNode(String k, Object o) {
			this.key = k;
			this.o = o;
		}
	}
	
	private final int MODULUS = 31;
	private final int BUCKETS = 3;
	Vector v = new Vector(BUCKETS);
	
	public HashMap() {
		
	}
	
	public int Hash(String s) {
		int hash = 0;
		for(int i = s.length() - 1; i>= 0; i--) {
			char c = s.charAt(i);
			hash += ((int)c) * Math.pow(MODULUS, i );
		}
		return hash;
	}
	
	public void add(String key, Object o) {
		int hash = Hash(key) % BUCKETS;
		LinkedList chain = (LinkedList)v.get(hash);
		if(chain == null ) {
			chain = new LinkedList();
			v.set(hash,  chain);
		} 
		for(int i = 0; i < chain.getSize(); i++) {
			HashNode n = (HashNode)chain.get(i);
			if(n.key == key) {
				n.o = o;
				return;
			}
		}
		chain.add( new HashNode(key,o));		
	}
	
	public Object get(String key) {
		int hash = Hash(key) % BUCKETS;
		LinkedList chain = (LinkedList)v.get(hash);
		if(chain == null ) {
			return null;
		}
		for(int i = 0; i < chain.getSize(); i++) {
			HashNode n = (HashNode)chain.get(i);
			if(n.key == key) {
				return n.o;
			}
		}
		return null;
	}
	
	public void remove(String key) {
		int hash = Hash(key) % BUCKETS;
		LinkedList chain = (LinkedList)v.get(hash);
		if(chain != null ) {
			for(int i = 0; i < chain.getSize(); i++) {
				HashNode n = (HashNode)chain.get(i);
				if(n.key == key) {
					chain.remove(i);
				}
			}
		}
	}	
}

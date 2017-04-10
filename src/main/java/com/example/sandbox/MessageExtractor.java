package com.example.sandbox;

public enum MessageExtractor implements Extract {
	INTEGER {

		@Override
		public String extract(Number number) {
			System.out.println("integer extractor called");
			return Integer.toString((Integer) number);
		}

	};

	public static MessageExtractor getCode(Number number) {
		String className = number.getClass().getSimpleName().toUpperCase();
		return valueOf(MessageExtractor.class, className);
	}

}

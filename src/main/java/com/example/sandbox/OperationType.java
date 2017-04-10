package com.example.sandbox;

public enum OperationType implements Operation {
	XOR {
		@Override
		public int apply(int x, int y) {
			return 0;
		}

	};
}

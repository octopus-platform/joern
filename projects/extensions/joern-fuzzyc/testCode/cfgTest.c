void switch_test1(void) {
	switch(x) {
		case 1: A();
		case 2: B();
		case 3: C();
	}
}

void switch_test2(void) {
	switch(x) {
		case 1: A(); 
		case 2: B(); break;
		case 3: C();
	}
}

void switch_test3(void) {
	switch(x) {
		case 1: A();
		case 2: B();
		default: C();
	}
}

void switch_test4(void) {
	switch(c) {
		case '1': A();
		case '2': B();
		case '3': C();
	}
}

void goto_test(void) {
loop:	if (x) {
		goto loop;
	}
}

void simple_for_test(void) {
	int i;
	for (i = 0; i < 10; i++) {
		A();
	}
}

void infinite_for_test(void) {
	for (; ;) {
		A();
	}
}

void for_test1(void) {
	for (; cond;) {
		A();
	}
}

void for_test2(void) {
	for (; cond; expr) {
		A();
	}
}

void complex_test(int a, int b, int c) {
start:	A();
	for (; x < 5;) {
		x++;
		while (y) {
			y--;
			if (c) {
				goto start;
			} else if (c - b) {
				goto end;
			} else if (c - a) {
				continue;
			}
			break;
		}
		c--;
	}
end:
	switch (a) {
		case 1:
		case 2: B();
		case 3: C(); break;
		default: D();
	}
}

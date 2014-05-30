void while_test(void) {
	int x = 10;
	while (x) {
		x--;
	}
	printf("%d", x);
}
void do_test(void) {
	int x = 10;
	do {
		x--;
	} while (x);
	printf("%d", x);
}
void for_test(void) {
	int i;
	for (i = 0; i < 10; i++) {
		printf("%d", i);
	}
	printf("%d", i);
}
void if_test(int arg1, int arg2) {
	if (arg1) {
		printf('if\n');
	} else if (arg2) {
		printf('else if\n');
	} else {
		printf('else\n');
	}
}

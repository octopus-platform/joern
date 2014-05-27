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


import java.util.*;

public class Game
{
	private int FIELD_SIZE = 3;
	public int STEP;
	public char simbol;
	public String result;
	
	String name1 = "Player 1";
	String name2 = "Player 2";
	
	String thisPlayer;
	String fullField;
	
	char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
	
	Scanner scanner = new Scanner(System.in);
	//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	//Заводим игроков
	public void addPlayer() {
		System.out.print("Введите имя игрока #1: ");
		name1 = scanner.nextLine();
		System.out.print("Введите имя игрока #2: ");
		name2 = scanner.nextLine();
	}
	
	// Отрисовываем игровое поле	
	public void paintField() {
		
		int x = 0;
		System.out.println();
		
		for (int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j  < FIELD_SIZE; j++) {
				x++;
				String value = Integer.toString(x);
				field [i][j] = value.charAt(0);
				System.out.print("[ " + field[i][j] + " ]");
			}
			System.out.println();
		}
	}
	// Обновляем игровое поле
	public void refreshField() {
		
		for (int i = 0; i < FIELD_SIZE; i++) {
			for (int j = 0; j < FIELD_SIZE; j++) {
				System.out.print("[ " + field[i][j] + " ]");
			}
			System.out.println();
		}
	}
	// Основной метод игры
	public void playGame() {
		addPlayer();
		paintField();
		for (STEP = 1; STEP <= FIELD_SIZE * FIELD_SIZE && STEP > 0; STEP++) {
			chetNechet();
			doStep();
			refreshField();
		//	System.out.println(STEP);
			chekWinner();
		}
		if (result != "Win") {
			result = "N";
			System.out.println();
			System.out.println("НИЧЬЯ ГОСПОДА!");
		}
		repeatGame();
	}

	// Делаем ход
	public void doStep() {
		System.out.println();
		System.out.print("Ходит " + thisPlayer + " (" + simbol + ")" + "! Введи номер ячейки: ");
		int i;
		if (scanner.hasNextInt()) {
			i = scanner.nextInt();
			switch (i) {
				case 1: 
					if (field[0][0] == 'X' || field[0][0] == 'O') {
						System.out.println("Эта ячейка занята");
						STEP--;
						break;
					} else {
					field[0][0] = simbol;
						break;
						}
				case 2: 
					if (field[0][1] == 'X' || field[0][1] == 'O') {
						System.out.println("Эта ячейка занята");
						STEP--;
						break;
					} else {
					field[0][1] = simbol;
						break;
						}
				case 3: 
					if (field[0][2] == 'X' || field[0][2] == 'O') {
						System.out.println("Эта ячейка занята");
						STEP--;
						break;
					} else {
					field[0][2] = simbol;
						break;
						}
				case 4: 
					if (field[1][0] == 'X' || field[1][0] == 'O') {
						System.out.println("Эта ячейка занята");
						STEP--;
						break;
					} else {
					field[1][0] = simbol;
						break;
						}
				case 5: 
					if (field[1][1] == 'X' || field[1][1] == 'O') {
						System.out.println("Эта ячейка занята");
						STEP--;
						break;
					} else {
					field[1][1] = simbol;
						break;
						}
				case 6: 
					if (field[1][2] == 'X' || field[1][2] == 'O') {
						System.out.println("Эта ячейка занята");
						STEP--;
						break;
					} else {
					field[1][2] = simbol;
						break;
						}
				case 7: 
					if (field[2][0] == 'X' || field[2][0] == 'O') {
						System.out.println("Эта ячейка занята");
						STEP--;
						break;
					} else {
					field[2][0] = simbol;
						break;
						}
				case 8: 
					if (field[2][1] == 'X' || field[2][1] == 'O') {
						System.out.println("Эта ячейка занята");
						STEP--;
						break;
					} else {
					field[2][1] = simbol;
						break;
						}
				case 9: 
					if (field[2][2] == 'X' || field[2][2] == 'O') {
						System.out.println("Эта ячейка занята");
						STEP--;
						break;
					} else {
					field[2][2] = simbol;
						break;
						}
				default: 
					System.out.println("Введено не верное значение! Попробуйте снова.");
					System.out.println();
					STEP--;
						break;
				}
		} else {
			String fuck  = scanner.nextLine();
			System.out.println("Введено что-то не понятное: !" + fuck);
			doStep();
		}
	}
	// Определяем кто из игроков ходит
	public void chetNechet() {
		if ((STEP % 2) == 0) {
			simbol = 'X';
			thisPlayer = name1;
		} else {
			simbol = 'O';
			thisPlayer = name2;
		}
	}
	
	// Выявляем победителя
	public void chekWinner() {
		if (
			// Строки
			   field[0][0] == 'X' && field[0][1] == 'X' && field[0][2] == 'X'
			|| field[1][0] == 'X' && field[1][1] == 'X' && field[1][2] == 'X'
			|| field[2][0] == 'X' && field[2][1] == 'X' && field[2][2] == 'X'
			// Столбцы
			|| field[0][0] == 'X' && field[1][0] == 'X' && field[2][0] == 'X'
			|| field[0][1] == 'X' && field[1][1] == 'X' && field[2][1] == 'X'
			|| field[0][2] == 'X' && field[1][2] == 'X' && field[2][2] == 'X'
			// Диагональ
			|| field[0][0] == 'X' && field[1][1] == 'X' && field[2][2] == 'X'
			|| field[2][0] == 'X' && field[1][1] == 'X' && field[0][2] == 'X'
		
			){
			winnerPresentation();
			result = "Win";
		} else {
			if (
				// Строки
				   field[0][0] == 'O' && field[0][1] == 'O' && field[0][2] == 'O'
				|| field[1][0] == 'O' && field[1][1] == 'O' && field[1][2] == 'O'
				|| field[2][0] == 'O' && field[2][1] == 'O' && field[2][2] == 'O'
				// Столбцы
				|| field[0][0] == 'O' && field[1][0] == 'O' && field[2][0] == 'O'
				|| field[0][1] == 'O' && field[1][1] == 'O' && field[2][1] == 'O'
				|| field[0][2] == 'O' && field[1][2] == 'O' && field[2][2] == 'O'
				// Диагональ
				|| field[0][0] == 'O' && field[1][1] == 'O' && field[2][2] == 'O'
				|| field[2][0] == 'O' && field[1][1] == 'O' && field[0][2] == 'O'
				){
				winnerPresentation();
				result = "Win";
			} else {
				if (STEP != 9) {
					System.out.println();
					System.out.println("Продолжаем бой!");
				}
			}
				
		}
		
	}
	
	// Объявляем победителя
	public void winnerPresentation () {
		System.out.println("Победил " + thisPlayer + " !");
		STEP = 9;
	}
	
	// Провереряем занятость ячеек
	public void fullChekField () {
		if (fullField == "F") {
			System.out.println("Ячейка уже использовалась");
			doStep();
		}
	}
	
	// Повтор игры
	public void repeatGame () {
		
		
		System.out.println();
		System.out.println("============================");
		System.out.print("Повторить бой (1 - да, 2 - нет)?");
		int i = scanner.nextInt();
		switch (i) {
			case 1:
				System.out.println();
				playGame();
				break;
			case 2:
				System.out.println();
				System.out.println("НУ И ХРЕН СТОБОЙ!");
				break;
			default:
				System.out.println("Не верный ответ");
				repeatGame();
				break;
		}
	}
}

//   0-1-2
// 0
// 1
// 2

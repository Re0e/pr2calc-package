// 以下のサンプルコード中の青い太字部分に、各自でさらにコードを追加せよ。
// 必要に応じて適切な場所に変数や処理を追加しても良い（その場合は必ず、追加したこと、及び追加の理由をコメントとして残すこと）。

package pr2calc;

public class Matrix {
        // 必要なフィールド（インスタンス）変数を宣言せよ
	double[][] m;
	int numOfRow, numOfColumn;

	public Matrix(){
		// 行列の行数,列数を格納するインスタンス変数の値を0に初期化
		this.numOfRow = this.numOfColumn = 0;
	}

	public Matrix(double[][] input){
		// 二次元配列 input の内容で、行列（インスタンス変数）を初期化せよ(例：配列 inputの0行0列目の値を、
		// 行列の0行0列目とする)
		this.numOfRow = input.length;
		this.numOfColumn = input[0].length;
		this.m = new double[this.numOfRow][this.numOfColumn];
		for(int i=0;i<this.numOfRow;i++){
			for(int j=0;j<this.numOfColumn;j++){
				this.m[i][j] = input[i][j];
			}
		}
	}

	public Matrix(double[] input){
		// 一次元配列 input の内容で、行列（インスタンス変数）を初期化せよ(例：行数は1、列数はinputの要素数とする)
		this.numOfRow = 1;
		this.numOfColumn = input.length;
		this.m = new double[this.numOfRow][this.numOfColumn];
		for(int i=0;i<this.numOfColumn;i++){
			this.m[0][i] = input[i];
		}
	}

	public int getNumOfRow(){
		return this.numOfRow;
    }
        

	public int getNumOfColumn(){
		return this.numOfColumn;
    }

	public double getComponentOf(int rowIndex, int columnIndex){
		// 指定した範囲が存在しない場合
                if(rowIndex < 0 || rowIndex >= this.numOfRow || columnIndex < 0 || columnIndex >= this.numOfColumn){
                        System.out.println("指定する要素は存在しません.");
                        System.exit(0);
                }
				return this.m[rowIndex][columnIndex];
                // 指定された要素に対応する値を返す
        }
        
	public void display(/* 引数は任意 */){
		// 行列内容の表示処理を実装せよ
		for(int i=0;i<this.numOfRow;i++){
			System.out.print("[ ");
			for(int j=0;j<this.numOfColumn;j++){
				System.out.print(this.m[i][j] + " ");
			}
			System.out.println("]");
		}
	}

	// ベクトルAとBの内積 A・Bの結果を返す
	public double getInnerProduct(Matrix B){
		// Aが列ベクトルである場合、エラーメッセージを表示させて System.exit(0)
		// A, B 双方とも行ベクトル、かつ、要素数が等しければ内積を計算
		// Aが行ベクトル、Bが列ベクトルで、要素数が等しければ内積を計算
		// 内積計算が可能な条件を満たさない場合は、エラーメッセージを表示させてSystem.out.exit(0)
		// 計算結果を返す
		double sum = 0.0;
		if(this.numOfColumn == 1)
		{
			System.out.print("Aが列ベクトルです");
			System.exit(0);
		}
		else
		{
			if(B.getNumOfRow() == 1 && this.numOfColumn == B.getNumOfColumn())
			{
				for(int i=0;i<this.numOfColumn;i++)
				{
					sum += this.m[0][i]*B.getComponentOf(0, i);
				}
			}
			else if(B.getNumOfColumn() == 1 && this.numOfColumn == B.getNumOfRow())
			{
				for(int i=0;i<this.numOfColumn;i++)
				{
					sum += this.m[0][i]*B.getComponentOf(i, 0);
				}
			}
			else
			{
				System.out.println("内積計算ができません");
				System.exit(0);
			}
		}

		return sum;
	}

	// 行列同士の乗算が可能であるかどうか判定する
	public boolean multipliable(Matrix y){
		// 判定処理を実装せよ
		if(this.numOfColumn == y.getNumOfRow()) return true;
		else
		{
			System.out.println("要素数が計算できる組み合わせとなっていません");
			return false;
		}

	}

        // 行列同士、もしくは行列とベクトルとの積を計算する
    public Matrix multiplyMatrix(Matrix target){

		// 行列演算が実施できるかどうかの判定は、メソッドに入る前に実行した方が難易度が低い
		//（Mainメソッドで、multiplyMatrixを実行する前段階で判定する方法でも良い）
		// 積の計算処理を実装せよ
               // 積の結果をMatrix型で返す
		Matrix answer = null;
		
		double[][] result = new double[this.numOfRow][target.getNumOfColumn()];
		for(int i=0;i<this.numOfRow;i++)
		{
			for(int j=0;j<target.getNumOfColumn();j++)
				for(int k=0;k<this.numOfColumn;k++)
					result[i][j] += this.m[i][k]*target.getComponentOf(k, j);
		}
		answer = new Matrix(result);
			
		return answer;
		
    }

	public static void main(String[] args) {


	}


}


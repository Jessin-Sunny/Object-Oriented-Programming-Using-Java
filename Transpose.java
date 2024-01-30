class Matrix
{
    int mat[][];
    int row,col,i,j;
    Matrix(int mat[][],int row,int col)
    {
        this.mat=mat;
        this.row=row;
        this.col=col;
    }
    void display(int mat[][],int row,int col)
    {
        for(i=0;i<row;i++)
        {
            for(j=0;j<col;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    Matrix transpose()
    {
        int tran[][]=new int[col][row];
        for(i=0;i<row;i++)
        {
            for(j=0;j<col;j++)
            {
                tran[j][i]=mat[i][j];
            }
        }
        return new Matrix(tran,col,row);
    }
    
}

public class Transpose
{
    public static void main(String args[])
    {
        int mat[][]={{10,20},
                    {30,40},
                    {50,60}};
        int row=3,col=2;
        Matrix matrix=new Matrix(mat,row,col);
        System.out.println("Given Matrix ");
        matrix.display(mat,row,col);
        Matrix tran;
        tran=matrix.transpose();
        System.out.println("Transpose Matrix ");
        tran.display(tran.mat,tran.row,tran.col);
    }
    
}

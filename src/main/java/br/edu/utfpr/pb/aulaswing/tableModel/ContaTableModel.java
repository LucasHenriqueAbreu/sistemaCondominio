package br.edu.utfpr.pb.aulaswing.tableModel;

import br.edu.utfpr.pb.aulaswing.model.Conta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ContaTableModel extends AbstractTableModel{
    private List<Conta> lista;
    private String[] colunas = {"Código", "Descrição"};
    
    public ContaTableModel(){
        lista = new ArrayList<>();
    }
    public ContaTableModel(List<Conta> lista){
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return lista.get(rowIndex).getId();
            case 1: return lista.get(rowIndex).getDespesa().getDataVencimento() 
                    +" Moradia:"+ lista.get(rowIndex).getDespesa().getMoradia().getSobrenome();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }
    
    public void removeRow(int rowIndex){
        this.lista.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
}

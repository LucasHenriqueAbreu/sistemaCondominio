package br.edu.utfpr.pb.aulaswing.tableModel;

import br.edu.utfpr.pb.aulaswing.model.Despesa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DespesaTableModel extends AbstractTableModel{
    private List<Despesa> lista;
    private String[] colunas = {"Código", "Paga", "Data Lançamento", "Data Vencimento", "Moradia"};
    
    public DespesaTableModel(){
        lista = new ArrayList<>();
    }
    public DespesaTableModel(List<Despesa> lista){
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
            case 1: return lista.get(rowIndex).getPaga();
            case 2: return lista.get(rowIndex).getDataLancamento();
            case 3: return lista.get(rowIndex).getDataVencimento();
            case 5: return lista.get(rowIndex).getMoradia().getSobrenome();
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
package br.edu.utfpr.pb.aulaswing.tableModel;

import br.edu.utfpr.pb.aulaswing.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CategoriaTableModel extends AbstractTableModel{
    private List<Categoria> lista;
    private String[] colunas = {"Código", "Descrição"};
    
    public CategoriaTableModel(){
        lista = new ArrayList<>();
    }
    public CategoriaTableModel(List<Categoria> lista){
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
            case 1: return lista.get(rowIndex).getDescricao();
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

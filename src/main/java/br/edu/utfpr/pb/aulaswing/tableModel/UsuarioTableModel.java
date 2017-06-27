package br.edu.utfpr.pb.aulaswing.tableModel;

import br.edu.utfpr.pb.aulaswing.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel{
    private List<Usuario> lista;
    private String[] colunas = {"Código", "Nome"};
    
    public UsuarioTableModel(){
        lista = new ArrayList<>();
    }
    public UsuarioTableModel(List<Usuario> lista){
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
            case 1: return lista.get(rowIndex).getNome();
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

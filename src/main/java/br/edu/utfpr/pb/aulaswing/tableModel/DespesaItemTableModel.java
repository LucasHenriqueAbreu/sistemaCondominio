package br.edu.utfpr.pb.aulaswing.tableModel;

import br.edu.utfpr.pb.aulaswing.model.DespesaItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DespesaItemTableModel extends AbstractTableModel{
    private List<DespesaItem> lista;
    private String[] colunas = {"Código", "Descrição", "Valor", "Quantidade", "Categoria"};
    
    public DespesaItemTableModel(){
        lista = new ArrayList<>();
    }
    public DespesaItemTableModel(List<DespesaItem> lista){
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
            case 2: return lista.get(rowIndex).getValor();
            case 3: return lista.get(rowIndex).getQuantidade();
            case 4: return lista.get(rowIndex).getCategoria().getDescricao();
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
package br.edu.unisep.gerenciartarefas.view;
import javax.swing.*;
import java.util.ArrayList;

public class GerenciadroDeTarefas {
    private final ArrayList<String> tarefas;

    public GerenciadroDeTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            String opcao = JOptionPane.showInputDialog(null,
                    "Selecione uma opção:\n\n" +
                            "1. Adicionar tarefa\n" +
                            "2. Marcar tarefa como concluída\n" +
                            "3. Remover tarefa\n" +
                            "4. Exibir todas as tarefas\n" +
                            "5. Sair",
                    "Gerenciador de Tarefas",
                    JOptionPane.QUESTION_MESSAGE);

            if (opcao == null || opcao.isEmpty()) continue;

            switch (opcao) {
                case "1":
                    adicionarTarefa();
                    break;
                case "2":
                    marcarConcluida();
                    break;
                case "3":
                    removerTarefa();
                    break;
                case "4":
                    exibirTarefas();
                    break;
                case "5":
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saindo do programa. Até logo!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        }
    }

    private void adicionarTarefa() {
        String tarefa = JOptionPane.showInputDialog(null, "Digite a nova tarefa:", "Adicionar Tarefa", JOptionPane.QUESTION_MESSAGE);
        if (tarefa != null && !tarefa.trim().isEmpty()) {
            tarefas.add(tarefa);
            JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Tarefa inválida! Nenhuma ação realizada.");
        }
    }

    private void marcarConcluida() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa para concluir!");
            return;
        }

        String lista = "Tarefas:\n";
        for (int i = 0; i < tarefas.size(); i++) {
            lista += (i + 1) + ". " + tarefas.get(i) + "\n";
        }

        String escolha = JOptionPane.showInputDialog(null, lista + "\nDigite o número da tarefa a concluir:",
                "Marcar como Concluída", JOptionPane.QUESTION_MESSAGE);
        try {
            int indice = Integer.parseInt(escolha) - 1;
            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.set(indice, tarefas.get(indice) + " (Concluída)");
                JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída!");
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida! Tente novamente.");
        }
    }


    private void removerTarefa() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa para remover!");
            return;
        }

        String lista = "Tarefas:\n";
        for (int i = 0; i < tarefas.size(); i++) {
            lista += (i + 1) + ". " + tarefas.get(i) + "\n";
        }

        String escolha = JOptionPane.showInputDialog(null, lista + "\nDigite o número da tarefa a remover:",
                "Remover Tarefa", JOptionPane.QUESTION_MESSAGE);
        try {
            int indice = Integer.parseInt(escolha) - 1;
            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.remove(indice);
                JOptionPane.showMessageDialog(null, "Tarefa removida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida! Tente novamente.");
        }
    }


    private void exibirTarefas() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa para exibir!");
        } else {
            String lista = "Tarefas:\n";
            for (int i = 0; i < tarefas.size(); i++) {
                lista += (i + 1) + ". " + tarefas.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, lista, "Lista de Tarefas", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

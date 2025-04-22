# 🧠 Padrão de Projeto Memento - Exemplo em Java

Este repositório contém implementações didáticas do **Padrão de Projeto Memento** em Java, com dois exemplos:

- ✅ Uma **versão simples** no terminal com as classes básicas (`main` branch)
- 🎨 Uma **versão visual com Java Swing** para desenhar e desfazer rabiscos (`master` branch)

---

## 🌱 Sobre o Padrão Memento

O **Padrão Memento** permite capturar e restaurar o estado interno de um objeto sem violar o encapsulamento. É muito usado em funcionalidades de **Undo/Redo**, como em editores de texto ou aplicativos de desenho.

### 🧩 Participantes do padrão:
- **Originator**: objeto que gera o estado (ex: `Canvas`)
- **Memento**: representa um snapshot (ex: `CanvasMemento`)
- **Caretaker**: gerencia os estados (ex: `CanvasHistory`)

---

## 🧪 Branch `main`: versão terminal (básica)

### 🔹 Descrição
Simula ações de desenhar e desfazer no terminal, armazenando riscos como strings em uma lista.

### 📦 Como rodar
```bash
git clone https://github.com/xandeoliveira/memento-exemplo.git
cd memento-exemplo
git checkout main
javac *.java
java Main
```

## 🖼️ Branch master: versão visual (Swing)

### 🔹 Descrição

Permite desenhar com o mouse e desfazer interações. Cada traço é salvo como um snapshot, usando o padrão Memento.
🖥️ Requisitos

    JDK 8 ou superior

📦 Como rodar

```bash
git clone https://github.com/xandeoliveira/memento-exemplo.git
cd memento-exemplo
git checkout master
javac *.java
java Main
```

### 📸 Interface

    🖱️ Clique e arraste para desenhar.

    🔁 Botão "Desfazer" para voltar ao estado anterior.

    🧼 Botão "Limpar" para limpar o canvas (com histórico salvo).

### 📁 Estrutura das classes principais

Canvas:	Originator (estado do desenho)

CanvasMemento:	Memento (snapshot do estado)

CanvasHistory:	Caretaker (histórico de estados)

Main:	Classe de execução

DesenhoFrame:	Janela principal (versão Swing)

CanvasPanel:	Painel de desenho (versão Swing)
package virtualcommandprompt;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vishn_000
 */
class Node {
    String data;
    Node parent = null;
    ArrayList<Node> child = null;
    Date date;
    String path;

    public Node(String data, Node parent, String path) {
        this.data = data;
        this.parent = parent;
        this.child = new ArrayList<Node>();
        date = new Date();
        this.path = path;
    }

    public Node getParentNode() {
        return parent;
    }

    public Date getDate() {
        return date;
    }

    public void addChild(Node child) {
        this.child.add(child);
    }

    public String getPath() {
        return path;
    }

    public String getData() {
        return data;
    }

    public ArrayList<Node> getChildren() {
        return child;
    }
}

class CommandPromptOperations {
    public Node root;
    public Node current;
    public Node parent;

    public void beginning() {
        root = new Node("\\", null, "\\");
        parent = root;
        current = root;
    }

    public void addChild(Node current, String folder, StringBuilder pathChild) {
        int flag = 0;
        for (int i = 0; i < current.getChildren().size(); i++) {
            if (current.getChildren().get(i).getData().equals(folder)) {
                System.out.println("Folder already Exist");
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            Node newNode = new Node(folder, current, pathChild.toString());
            current.addChild(newNode);
        }
    }

    public int checkExistence(int indexArray, Node start, String[] arraySplitted) {
        if (start == null) {
            return -1;
        }
        for (int j = 0; j < start.getChildren().size(); j++) {
            if (start.getChildren().get(j).getData().equals(arraySplitted[indexArray])) {
                checkExistence(indexArray++, start.getChildren().get(j), arraySplitted);
            }
        }
        return indexArray;
    }

    public void createFolder(String folder, StringBuilder path) {
        String[] arraySplit = folder.split("\\\\");
        StringBuilder pathChild;
        if (arraySplit.length == 0) {
            pathChild = new StringBuilder(path);
            addChild(current, folder, pathChild.append(folder));
        } else {
            int index;
            Node startNode;
            if (folder.charAt(0) == '\\') {
                startNode = root;
                index = 1;
            } else {
                index = 0;
                startNode = current;
            }
            if (startNode.getChildren() == null && startNode.getData().equals(arraySplit[index])) {
                pathChild = new StringBuilder(path);
                addChild(startNode, arraySplit[arraySplit.length - 1], pathChild.append("\\").append(arraySplit[index + 1]));
            } else {
                index = checkExistence(index, startNode, arraySplit);
                if (index == arraySplit.length - 1) {
                    if (folder.charAt(0) == '\\') {
                        pathChild = new StringBuilder(folder);
                        addChild(startNode, arraySplit[arraySplit.length - 1], pathChild);
                    } else {
                        pathChild = new StringBuilder(path);
                        pathChild.append("\\");
                        addChild(startNode, arraySplit[arraySplit.length - 1], pathChild.append(folder));
                    }
                } else {
                    System.out.println("Folder does not exist");
                }
            }
        }
    }

    public void changeDirectory(String folder, StringBuilder path) {
        String[] arraySplit = folder.split("\\\\");
        int flag = 0;
        if (arraySplit.length == 1) {
            for (int i = 0; i < current.getChildren().size(); i++) {
                if (current.getChildren().get(i).getData().equals(folder)) {
                    current = current.getChildren().get(i);
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("Folder does not exist");
            } else {
                if (path.charAt(path.length() - 1) != '\\') {
                    path.append("\\");
                }
                path.append(folder);

            }
        }
    }

    public void lsCommand() {
        int count = 0;
        if (current.getChildren().size() == 0) {
            System.out.println("Folder is empty");
        } else {
            for (int i = 0; i < current.getChildren().size(); i++) {
                System.out.println(current.getChildren().get(i).getDate());
                System.out.println(current.getChildren().get(i).getData());
                for (int j = 0; j < current.getChildren().get(i).getChildren().size(); j++) {
                    count = count + 1;
                }
            }
            System.out.println("Total subfolders: " + count);
        }
    }

    public void back(StringBuilder path) {
        if (current.getData().length() == 1) {
            System.out.println("Its root directory. no parent exist");
        } else {
            current = current.getParentNode();
            if (current.getParentNode() != null) {
                parent = current.getParentNode();
            } else {
                parent = null;
            }
            String[] arrayPath = new StringBuilder(path).toString().split("\\");
            for (int i = 0; i < arrayPath.length - 1; i++) {
                path.append("\\");
                path.append(arrayPath[i]);
            }
        }
    }

    public void findFolder(String folder, Node current) {
        Node startNode = current;
        if (startNode == null) {
            return;
        }
        for (int j = 0; j < startNode.getChildren().size(); j++) {
            String regex = folder;
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher;
            if (pattern.matcher(startNode.getChildren().get(j).getData()).find()) {
                System.out.println(startNode.getChildren().get(j).getPath());
            }
            findFolder(folder, startNode.getChildren().get(j));
        }
        return;
    }

    public void displayTree(Node current) {
        Node startNode = current;
        if (startNode == null) {
            return;
        }
        for (int j = 0; j < startNode.getChildren().size(); j++) {
            System.out.print("-> " + startNode.getChildren().get(j).getData());
            displayTree(startNode.getChildren().get(j));
        }
        return;
    }
}

public class VirtualCommandPrompt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CommandPromptOperations operations = new CommandPromptOperations();
        String command;
        operations.beginning();
        StringBuilder path = new StringBuilder("\\");
        String data;
        do {
            System.out.print(path);
            command = sc.nextLine();
            String[] array = command.split(" ");
            if (array[0].equals("mkdir")) {
                operations.createFolder(array[1], path);
            } else if (array[0].equals("cd")) {
                operations.changeDirectory(array[1], path);
            } else if (array[0].equals("bk")) {
                operations.back(path);
            } else if (array[0].equals("ls")) {
                operations.lsCommand();
            } else if (array[0].equals("find")) {
                operations.findFolder(array[1], operations.current);
            } else if (array[0].equals("tree")) {
                operations.displayTree(operations.root);
            } else if (array[0].equals("exit")) {
                System.exit(0);
            } else {
                System.out.println("Command is invalid");
            }
        } while (true);
    }
}

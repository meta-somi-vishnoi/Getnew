package collegeprograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
class StudentProgram {

    public void readInputFile(String fileName, List<Object> list){
        FileInputStream inputStream;
        System.out.println(fileName);
        try {
        inputStream = new FileInputStream(new File(fileName));
        String name=null;
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if("C:\\Users\\vishn_000\\Downloads\\Programs.xlsx".equals(fileName)) {
                    switch (cell.getCellTypeEnum()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        name=cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        DetailsOfProgramAllocation program = new DetailsOfProgramAllocation(name,(int)cell.getNumericCellValue());
                        list.add(program);
                        break;
                    }
                }
                else if("C:\\Users\\vishn_000\\Downloads\\Student.xlsx".equals(fileName)) {
                    switch (cell.getCellTypeEnum()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        name=cell.getStringCellValue();
                        list.add(cell.getStringCellValue());
                    break;
                    }
                }
            }
        }
        workbook.close();
        inputStream.close();
        }catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void writeToFile(List<Output> resultantList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Student programs");
        int rownum = 0;
        for(int i=0;i<resultantList.size();i++) 
        {
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            for (int j=0;j<2;j++) 
            {
                Cell cell = row.createCell(cellnum++);
                if (j==0) 
                {
                    System.out.println((String)resultantList.get(i).getNameOfStudent());
                    cell.setCellValue((String)resultantList.get(i).getNameOfStudent());
                }
                else if (j==1) 
                {
                    System.out.println((String)resultantList.get(i).getCourse());
                    cell.setCellValue((String)resultantList.get(i).getCourse());
                }
            }
        }
        try 
        {
            FileOutputStream out = new FileOutputStream(new File("C:\\Users\\vishn_000\\Downloads\\StudentProgram.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("written successfully on disk.");
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void subjectAllocate(Student student, List<Object> programObjectList, String subject) {
        for(int i=0;i<programObjectList.size();i++) {
            if(subject.equals(((DetailsOfProgramAllocation)programObjectList.get(i)).getName()) && ((DetailsOfProgramAllocation)programObjectList.get(i)).getCapacity()>=1) {
                student.setSubjectAllocated(((DetailsOfProgramAllocation)programObjectList.get(i)).getName());
                ((DetailsOfProgramAllocation)programObjectList.get(i)).setCapacity();
                break;
            }
        }
    }
    
    public void studentProgramAllocation() {
        QueueUsingLinkList queueOfStudents = new QueueUsingLinkList();
        List<Object> programObjectList = new ArrayList<Object>();
        System.out.println("In stpa");
        readInputFile("C:\\Users\\vishn_000\\Downloads\\Programs.xlsx", programObjectList);
        List<Object> studentObjectList = new ArrayList<Object>();
        readInputFile("C:\\Users\\vishn_000\\Downloads\\Student.xlsx", studentObjectList);
        System.out.println(studentObjectList.size());
        System.out.println(programObjectList.size());
        for(int i=0;i<studentObjectList.size();i=i+6) {
            System.out.println("In list");
            Student student = new Student((String)studentObjectList.get(i),(String)studentObjectList.get(i+1),(String)studentObjectList.get(i+2),(String)studentObjectList.get(i+3),(String)studentObjectList.get(i+4),(String)studentObjectList.get(i+5));
            queueOfStudents.addItemToQueue(student); 
        }
        ArrayList<Output> resultantList = new ArrayList<Output>();
        Student student;
        String subject;
        while(!queueOfStudents.isQueueEmpty()) {
            student=queueOfStudents.deleteItemFromQueue();
            if(student.getSubjectAllocated().equals("  ")) {
                subject=student.getFirstPreference();
                subjectAllocate(student,programObjectList,subject);
            }
            else if(student.getSubjectAllocated().equals(" ")) {
                subject=student.getSecondPreference();
                subjectAllocate(student,programObjectList,subject);
            }
            else if(student.getSubjectAllocated().equals(" ")) {
                subject=student.getThirdPreference();
                subjectAllocate(student,programObjectList,subject);
            }
            else if(student.getSubjectAllocated().equals(" ")) {
                subject=student.getFourthPreference();
                subjectAllocate(student,programObjectList,subject);
            }
            else if(student.getSubjectAllocated().equals(" ")) {
                subject=student.getFifthPreference();
                subjectAllocate(student,programObjectList,subject);
            }
            else if(student.getSubjectAllocated().equals(" ")){
                student.setSubjectAllocated("Nill");
            }
            resultantList.add(new Output(student.getStudentName(),student.getSubjectAllocated()));
        }
        writeToFile(resultantList);
    }
}

public class StudentCollegeProgramAllocation{
    public static void main(String[] args) {
        StudentProgram program = new StudentProgram();
        program.studentProgramAllocation();
    }
}
package refactoring.problema3.utils;

public class File {
  public static List<String[]> readCsv(String csvFilename, String delimiter) {
    List<String[]> data = new ArrayList<String[]>();

    try (BufferedReader br = new BufferedReader(new FileReader(csvFileSales))) {
      String line = br.readLine();

      while ((line = br.readLine()) != null) {
        data.add(line.split(delimiter));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return data;
  }
}


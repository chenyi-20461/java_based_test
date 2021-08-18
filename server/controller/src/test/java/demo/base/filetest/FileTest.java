package demo.base.filetest;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

/**
 * 文件目录测试类
 */
public class FileTest {
    /**
     * 遍历文件流会出现无法无权限访问的问题.
     */
    @SneakyThrows
    @Test
    public void testWalk() {
        Stream<Path> stream = Files.walk(Paths.get("D:\\"), 2, FileVisitOption.FOLLOW_LINKS);
        stream.filter(a -> a.toString().contains("down")).forEach(path -> {
            System.out.println(path.toString());
        });
    }

    /**
     * 遍历目录下文件.
     * <p>
     * preVisitDirectory 访问一个目录，在进入之前调用。
     * postVisitDirectory 一个目录的所有节点都被访问后调用。遍历时跳过同级目录或有错误发生，Exception会传递给这个方法
     * visitFile 文件被访问时被调用。该文件的文件属性被传递给这个方法
     * visitFileFailed 当文件不能被访问时，此方法被调用。Exception被传递给这个方法。
     * <p>
     * SimpleFileVisitor
     * CONTINUE 继续遍历
     * SKIP_SIBLINGS 继续遍历，但忽略当前节点的所有兄弟节点直接返回上一层继续遍历
     * SKIP_SUBTREE 继续遍历，但是忽略子目录，但是子文件还是会访问
     * TERMINATE 终止遍历
     */
    @Test
    public void testFile2() {
        int[] count = {0};
        try {
            File dir = new File("D:\\");
            Path path = Files.walkFileTree(Paths.get(dir.getPath()), new HashSet<FileVisitOption>(Arrays.asList(FileVisitOption.FOLLOW_LINKS)),
                    2, new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            System.out.printf("Visiting file %s\n", file);
                            ++count[0];

                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {
                            System.err.printf("Visiting failed for %s\n", file);

                            return FileVisitResult.SKIP_SUBTREE;
                        }

                        @Override
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                            System.out.printf("About to visit directory %s\n", dir);
                            return FileVisitResult.CONTINUE;
                        }
                    });

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

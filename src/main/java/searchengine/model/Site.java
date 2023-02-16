package searchengine.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
    @Table(name = "site")
    @Data
    public class Site {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", columnDefinition = "INT", nullable = false)
        private int id;
        @Enumerated(EnumType.STRING)
        @Column(columnDefinition = "ENUM('INDEXING', 'INDEXED', 'FAILED')", nullable = false)
        private Status status;
        @Column(name ="status_time", columnDefinition = "DATETIME", nullable = false)
        private Date statusTime;
        @Column(name ="last_error", columnDefinition = "TEXT", nullable = false)
        private String lastError;
        @Column(name ="url", columnDefinition = "VARCHAR(255)", nullable = false)
        private String url;
        @Column(name ="name", columnDefinition = "VARCHAR(255)", nullable = false)
        private String name;
        @OneToMany(cascade = CascadeType.REMOVE)
        private List<Page> pages;
    }

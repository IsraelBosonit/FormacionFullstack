package com.example.DB1.domain;

import com.example.DB1.StringPrefixedSequenceIdGenerator;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @GenericGenerator(
            name = "student_seq",
            strategy = "com.example.DB1.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "STD"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    private String id_student;
    @JoinColumn(name="id_persona")
    @OneToOne(fetch=FetchType.LAZY)
    private Persona persona;
    @NotNull
    private Integer num_hours_week;
    private String coments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profesor")
    private Profesor profesor;
    private String branch;
    @OneToMany(mappedBy="student")
    private List<Estudiante_Asignatura> asignaturas;

}

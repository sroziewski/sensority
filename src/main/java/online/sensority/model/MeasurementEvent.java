package online.sensority.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementEvent {
    private static final long serialVersionUID = -4981161628784858616L;

    private String movieId;
    private String theatre;
    private Date date;
}
